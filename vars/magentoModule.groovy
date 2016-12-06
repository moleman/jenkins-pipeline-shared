def call(Closure body) {
    node {
        stage('Generate Composer Package') {
            build 'generate composer package'
        }
        
        stage('General build step') {
            sh "echo Test"
            sh "echo name: ${config.name}"
            sh "pwd"
            sh "printenv"
        }
        
        stage('Job specific build step') {
            body()
        }
    }
}
