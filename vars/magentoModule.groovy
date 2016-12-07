def call() {
    stage('Generate Composer Package') {
        build 'generate composer package'
    }
    
    stage('Code check') {
        stage('Validate Composer') {
            sh "composer validate"
        }

        stage('PHP Lint') {
            sh "find . -name '*.php' -print0 | xargs -0 -n1 -P10 php -l -ddisplay_errors=on"
        }
    }
}
