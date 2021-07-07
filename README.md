# MyAssessmentsRepo
All my Challenge Tasks
# Challenge1
3-tier application in AWS Sample terraform code
cd to terraform folder and run the below commands terraform commands
1. export TF_VAR_FILE_PATH='../configs/dev/dev.tfvars'
2. terraform init 
3. terraform plan -detailed-exitcode -var-file="${TF_VAR_FILE_PATH}"
4. terraform apply -var-file="${TF_VAR_FILE_PATH}"
5. terraform destroy -var-file="${TF_VAR_FILE_PATH}"

# Challenge2
groovy code to get instance meta data in gcp 
run the below command in bash shell to invoke groovy script

`groovy gcp_Metadata_Key '<GCP_Project_ID>' '<InstanceID>' '<keytofetch>'`

Expected Output: 

`got the Metadata of instance by key is:: myjumpbox`
# Challenge3
Nestedobject function to find a key value
run the below command in bash shell to invoke groovy script

`groovy obj_nested_Key`

Expected Output: 

`[grandX, parentY, childZ]

getting child-Z value is ::  myselfIsValue`
