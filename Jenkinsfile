
// Variables for input
/*
https://stackoverflow.com/questions/44099851/how-do-i-pass-variables-between-stages-in-a-declarative-jenkins-pipeline
*/
def inputProjectName = "?"
def inputProjectVersion = "latest"
    try{
        inputProjectName = "${project.name}"
    }catch(Exception e){
        inputProjectName = "?"
    }

pipeline {
    agent any
    stages {
        stage('Set Parameters') {
            steps {
                script {
                    /*
                    https://stackoverflow.com/questions/38597006/input-step-with-timeout-which-continues-with-default-settings-using-jenkins-pipe
                    */
                    try {
                        timeout(time: 30, unit: 'SECONDS') {
                        // Get the input
                        def userInput = input(
                        id: 'userInput', message: 'project name and version:?',
                        parameters: [

                        string(defaultValue: inputProjectName,
                        description: 'Project name',
                        name: 'ProjectName'),
                        string(defaultValue: inputProjectVersion,
                        description: 'Project version',
                        name: 'ProjectVersion'),
                        ])

                        echo("userInput: ${userInput}")
                        // Save to variables. Default to empty string if not found.
                        inputProjectName = userInput.ProjectName?:''
                        inputProjectVersion = userInput.ProjectVersion?:''
                        // Echo to console
                        echo("Project name: ${inputProjectName}")
                        echo("Proj version: ${inputProjectVersion}")
                        }
                    } catch (err) {
                        def user = err.getCauses()[0].getUser()
                        if('SYSTEM' == user.toString()) { // SYSTEM means timeout
                            echo ("Input timeout expired, default will be used: ${inputProjectName}/${inputProjectVersion}")
                        } else {
                            echo "Input aborted by: [${user}]"
                            error("Pipeline aborted by: [${user}]")
                        }
                    }
                }
            }
        }
        stage('build jenkins job') {
            steps {
                script {
                    build "${inputProjectName}"
                }
            }
        }
    }
}
