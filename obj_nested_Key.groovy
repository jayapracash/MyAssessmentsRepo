
import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def result = slurper.parseText('{"grandX":{"parentY":{"childZ":"myselfIsValue"}}}')
def key = 'grandX/parentY/childZ'
def parseKeys = key.tokenize('/')
println parseKeys
println "getting child-Z value is ::  " + result.get(parseKeys[0]).get(parseKeys[1]).get(parseKeys[2])
