node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"
    
    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "cliente"
    registryHost = "http://10.51.33.59:5000/"
    //imageName = "${appName}:${tag}"
    imageName = "jovaniac/servicio-cliente:0.0.1-ci-cd"
    env.BUILDIMG=imageName
	
 
 	stage('Gradle Build') {
	    if (isUnix()) {
	        sh './gradlew clean buildImage'
	    } else {
	        bat 'gradlew.bat clean build'
	    }
	}
	
	 stage "Build Image"
        	echo 'Building..'
        	sh "docker build -t ${imageName} build/libs/"
		echo 'End Building..'
	
	 stage "Push"
		echo 'Pushing..'
        	sh "docker push ${imageName}"
		echo 'End Pushing..'

	
    
 /*   stage "Deploy"
     	echo 'Deploying...'
	sh "kubectl apply -f kubernetes/servicio-cliente-dep.yaml"
	sh "kubectl apply -f kubernetes/servicio-cliente-svc.yaml"
		echo 'End Deploying..'*/
}
