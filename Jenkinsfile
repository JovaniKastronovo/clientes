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
  
}
