pipeline {
    agent any
    tools {
        maven 'maven jenkins'
    }
    parameters {
        choice(name: 'TAG', choices: ['wb', 'wb2'], description: 'Choose the tag')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Получить код из репозитория GitHub
                    git branch: 'main', url: 'https://github.com/anyonmari/test2.git'
                    sh "mvn clean test -Dgroups=${params.TAG}"
                    sh 'ls -la target/allure-results'
                }
            }
        }


    }

   post {
           always {
               // Генерация отчета Allure
               script {
                   allure includeProperties: false, jdk: '1.8', results: [[path: 'target/allure-results']]
               }
               // Архивирование артефактов и запись результатов тестов
               archiveArtifacts artifacts: '**/target/allure-results/**', allowEmptyArchive: true
               junit '**/target/surefire-reports/*.xml'
           }
       }
}