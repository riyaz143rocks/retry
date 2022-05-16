pipeline {
    agent none
    stages {
        stage('Reach the bridge') {
            steps {
                infoMessage 'Stop. Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.'
            }
        }
        stage('Answer a question') {
            steps {
                script {
                    favouriteColour = retryContinueOrAbort {
                        infoMessage 'What... is your favourite colour?'
                        error 'Blue. No, yel... [he is also thrown over the edge] auuuuuuuugh.'
                    }
                }
            }
        }
        stage('Get POM Version') {
            steps {
                successMessage 'You have made it past the bridge keeper!'
                script {
                    mavenVersion = retryContinueOrAbort {
                        "0.0.1-SNAPSHOT"
                    }
                }
            }
        }
        stage('Print Variables') {
            steps {
                successMessage "favouriteColour: ${favouriteColour}"
                successMessage "mavenVersion: ${mavenVersion}"
            }
        }
    }
}
