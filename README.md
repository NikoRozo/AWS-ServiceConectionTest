# AWS-ServiceConectionTest
Proyecto de Prueba de Concepto Conexión a Servicios de AWS y LocalStack

## Prerequisitos
- Cuenta de AWS
- Java JDK 11
- Spring Suite Tool 4
- AWS CLI (https://docs.aws.amazon.com/es_es/cli/latest/userguide/install-cliv2.html)
- Complemento Lombok Eclipse (https://projectlombok.org/download)
- Configurar credencias de AWS en AWS CLI
- Docker Desktop
- Dockerfile de LocalStack (https://github.com/NikoRozo/Docker_Practicas/blob/master/localstack/docker-compose.yml) - Windows

## Dumentación Relevante
- TestContainer (https://www.testcontainers.org/modules/localstack/)
- Guia AWS SDK para Java 2.0 (https://docs.aws.amazon.com/es_es/sdk-for-java/v2/developer-guide/welcome.html)
- Ejemplos en AWS y LocalStack (https://gist.github.com/lobster1234/57e803ebca47c3c263a9d53ccd1f1783)
- Ejemplos con AWS SDK 2.0 (https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code)

# Configuración de Credenciales en AWS
Una vez instalado el CLI de AWS procedemos a realizar la consfiguración de nuestra Access Key ejecutando los siguientes comandos:

`aws configure`

Ingresan los del Access Key

`AWS Access Key ID [None]: ****************2MF7`

`AWS Secret Access Key [None]: **************************5NwUe`

`Default region name [None]: us-east-1`

`Default output format [None]: json`

Habilitar Autocompletado

`complete -C aws_completer aws`

Listar los recursos s3 de la cuenta configurada

`aws s3 ls`

`aws dynamodb list-tables`

# Instalación de LocalStack Linux o WSL 2.0

Prerequisitos:

`sudo apt install -y python3`

`sudo apt install -y python3-pip`

`sudo apt-get install -y libsasl2-dev`

Intalar LocalStack:

`sudo python3 -m pip install localstack`

Asi, podemos ejecutar Localstack apoyandonos con Docker, pero si deseamos ejecutarlo de forma nativa debemos ejecutar:

`sudo apt install curl`

`sudo curl -sL https://deb.nodesource.com/setup_12.x -o nodesource_setup.sh`

`sudo bash nodesource_setup.sh`

`sudo apt install nodejs`

`sudo apt install git`

`sudo apt install -y openjdk-8-jdk`

Pare ejecutarlo con Docker instalamos:

`sudo apt install docker.io`

`sudo apt install docker-compose`

**Nota**: Si estamos utilizando Windows podemos habilitar WSL 2 y omitimos este paso, ya que Docker se podra ejecutar en nuestras instancias de WSL.

Para ejecutar localstack nativo ejecutamos:

`sudo localstack start --host`

Para Ejecutar localstack con docker, ejecutamos:

`sudo localstack start`

Para finalizar intalamos awslocal:

`pip install awscli-local`

Desde el CLI de AWS ponemos agregar el Flag endpoint para utilizar el recurso de LocalStack, como se muestra acontinuación:

`aws --endpoint-url=http://localhost:4569 dynamodb list-tables`

Intalamos el CLI de AWSLocal, para que se transparente, y ejecutamos el mismo comando pero con awslocal:

`awslocal synamodb list-tables`

# Ejecutar el Proyecto

Se puede ejecutar desde el IDE Spring Suite Tool, el cual expondra un servicio Rest en el pueto 9000:

`http://localhost:9000/create/dynamo/{tableName}`

El servicio nos retornara la lista de tablas en DynamoDB creadas:

`
[
  "MyTabla",
  "book"
]
`

Si miramos nuestro archivo application.properties, vemos que expesificamos el endpoint del localstack

`dynamo.endpointURI=http://localhost:4569`

Si quitamos esta propiedad, nuestro servicio creara la tabla en nuestra cuenta de AWS.