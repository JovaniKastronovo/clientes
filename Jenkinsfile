node {


    env.DOCKER_API_VERSION="1.23"
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "cliente"
    registryHost = "http://10.51.33.59:5000/"
    //imageName = "${appName}:${tag}"
    imageName = "jovaniac/servicio-cliente:0.0.1-ci-cd"
    env.BUILDIMG=imageName
  
   stage('Descargando Codigo') {
    checkout scm
   }
  
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

     stage('Push to Docker Registry'){
      withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
             sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
             sh "docker push ${imageName}"
           }
    }
    
    stage('Deploy Kubernetes'){
         sh("kubectl apply -f kubernetes/")
    }
    
    /* stage('do some kubectl work') {
            container('kubectl') {

                withCredentials([[$class: 'UsernamePasswordMultiBinding', 
                        credentialsId: 'dockerhub',
                        usernameVariable: 'DOCKER_HUB_USER',
                        passwordVariable: 'DOCKER_HUB_PASSWORD']]) {
                    
                    sh "kubectl get nodes"
                }
            }
}*/
    
     /*stage('Deploy Kubernetes'){
         sh("kubectl apply -f kubernetes/")
    }*/
      
  /*stage('Push to Docker Registry'){
          withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push ${imageName}'
    }
     }*/

    
  
    
 /*   stage "Deploy"
      echo 'Deploying...'
  sh "kubectl apply -f kubernetes/servicio-cliente-dep.yaml"
  sh "kubectl apply -f kubernetes/servicio-cliente-svc.yaml"
    echo 'End Deploying..'*/
}
