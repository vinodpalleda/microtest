pipeline{
    agent any
    environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
   
    stages{
       stage('GetCode'){
            steps{
                git branch: 'feature/homescreen_entity_mapping',
                url: 'https://bitbucket.org/r_kumar1/adminms.git'
             sh "ls -lat"
            
                
            }
         }        
       stage('Build'){
            steps{
                sh 'sudo mvn clean install'
            }
         }
         stage('Deploy') {
         steps{
        //sh 'sudo cd /var/lib/jenkins/workspace/Backend_Application/target'
        sh 'pwd'
        sh 'sudo sh /var/lib/jenkins/workspace/admin_deploy.sh'
        sh "sudo sshpass -p 'digi@2022' ssh digiusr@192.168.94.28 '/home/ADMINMS/myapp.sh'"
         }
    }
    }
	


    }
