import os

class Config:
    MYSQL_HOST = 'mysql-flask-container'  # nombre del contenedor en docker-compose
    MYSQL_USER = 'root'
    MYSQL_PASSWORD = os.getenv('MYSQL_PASSWORD', '1234UBU')
    MYSQL_DB = os.getenv('FLASK_DB', 'sisdisrequirements')
