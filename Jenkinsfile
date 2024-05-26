pipeline {
    agent any
    tools {
        maven 'maven jenkins'
    }
    parameters {
        choice(name: 'TAG', choices: ['wb', 'wb1'], description: 'Choose the tag')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Получить код из репозитория GitHub
                    git branch: 'main', url: 'https://github.com/anyonmari/test.git'
                    sh "mvn clean test -Dtags=${params.TAG}"
                    sh 'ls -la target/allure-results'
                }
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '1.7', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/allure-results/**', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}