pipeline {
    // Definir el agente donde se ejecutará el pipeline (puede ser cualquier nodo disponible)
    agent any

    // Definir variables de entorno, como rutas y configuraciones
    environment {
        // Ruta al directorio System32 de Windows
        SYSTEM_PATH = "C:\\Windows\\System32"
        // Ruta al directorio bin de Apache Maven
        MAVEN_PATH = "C:\\DEV\\apache-maven-3.9.6\\bin"
        // Ruta al directorio bin de Java JDK
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        // Agregar las rutas al PATH para que las herramientas puedan ser ejecutadas
        PATH = "${SYSTEM_PATH};${MAVEN_PATH};${JAVA_HOME}\\bin"
    }

    // Definir las etapas del pipeline
    stages {
        // Etapa: Preparación del proyecto
        stage('Preparación del proyecto') {
            steps {
                // Obtener el código fuente del repositorio Git
                checkout scm
            }
        }
        
        // Etapa: Construcción del proyecto
        stage('Construcción del proyecto') {
            steps {
                // Ejecutar el comando 'mvn clean package' utilizando el plugin 'bat'
                bat 'mvn clean package'
            }
        }

        // Etapa: Pruebas y resultados
        stage('Pruebas y resultados') {
            steps {
                // Ejecutar el comando 'mvn test' para ejecutar pruebas
                bat 'mvn test'
            }
            post {
                always {
                    // Publicar resultados de pruebas utilizando el plugin 'junit'
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
    
    // Configuración de acciones posteriores al pipeline
    post {
        success {
            // Archivar artefactos después de una ejecución exitosa
            archiveArtifacts artifacts: '**/target/*.war', allowEmptyArchive: true
        }
    }
}
