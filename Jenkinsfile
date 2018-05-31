node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"
    
    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "cliente"
    registryHost = "http://10.51.33.59:5000/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName
	
    stage "Test"
	echo 'Testing..'
	echo 'End Testing..'
 
 	stage('Gradle Build') {
	    if (isUnix()) {
	        sh 'gradle clean buildImage  -Dhttp.proxyHost=10.50.8.20 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=10.50.8.20 -Dhttps.proxyPort=8080'
	    } else {
	        bat 'gradlew.bat clean build'
	    }
	}
	
    stage "Build"
        echo 'Building MicroService Cliente..'
        sh "docker build -t ${imageName} build/lib/"
	echo 'End Building..'
    
    stage "Push"
	echo 'Pushing in Registry'
        sh "docker push ${imageName}"
	echo 'End Pushing..'
	
    
    stage "Deploy"
     	echo 'Deploying...'
	sh "kubectl apply -f kubernetes/servicio-cliente-dep.yaml"
	sh "kubectl apply -f kubernetes/servicio-cliente-svc.yaml"
		echo 'End Deploying..'
}