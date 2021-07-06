
import groovy.json.JsonSlurper

main()

def main(){
 println "got the inputs : " + this.args
 //gcpAuthentication()
 println "authentication successfull"
 def jsonResponse = getMetadata()
 println "metadata fetch successfull"
 def key = this.args[1]
 def metadataParsed = parseJsonbyKey(jsonResponse,key)
 println "got the Metadata of instance by key is:: " + metadataParsed
}
def gcpAuthentication(){
	try{
		def projectID = this.args[0]?:'gcp-project-dr-jpapp'
		println "project is : "+ projectID
		def command = """
		gcloud config set project ${projectID}
		gcloud auth activate-service-account --key-file="sakey.json"
		gcloud config list
		"""// Create the String
		def proc = ['bash', '-c', command].execute()            // Call *execute* on the string, put sakey.json in cwd to authenticate gcp
		proc.waitFor() 
		println "return code: ${ proc.exitValue()}"		
		println "stderr: ${proc.err.text}"
		println "stdout: ${proc.in.text}"

		if ((proc.exitValue() == 1)) {
				throw new Exception("ERROR: Unable to execute authentication commands")
		   }	
	} catch (Exception ex) {
		println("Authentication Failed with following exception:\n\n" + ex.getMessage())
		throw ex
	}
}

def getMetadata(){
	def procc
	def result
	try{
		def instanceID = this.args[1]?:'608636953967817142'
		println "instance is : "+ instanceID
		def command = """
		timeout 300s gcloud compute instances describe ${instanceID} --zone=us-central1-a --format="json"
		"""// Create the String
		procc = ['bash', '-c', command].execute()            // Call *execute* on the string
		procc.waitFor() 
		println "return code: ${ procc.exitValue()}"		
		println "stderr: ${procc.err.text}"
		println "stdout: ${procc.in.text}"
		result = procc.in.text
		println "Std Out: $result"

		if ((proc.exitValue() != 0)) {
				throw new Exception("ERROR: Unable to execute metadata commands")
		   }	
		   
	} catch (Exception ex) {
		println("Fetching metadata Failed with following exception:\n\n" + ex.getMessage())
		throw ex
	}
	return "${procc.in.text}"
}
		
def parseJsonbyKey(jsonResponse,key){
	String json = "${jsonResponse}"
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(jsonString)
	String idValue = parsedJson.get(key)
	//String idValue2 = parsedJson.get("menu").get("id")
	return idValue
}
		  
		
		
