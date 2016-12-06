def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        stage('Build') {
            sh "echo Test"
            sh "echo name: ${config.name}"
            sh "pwd"
            sh "printenv"
        }
    }
}
