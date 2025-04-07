import mysql.connector
from config import Config

def get_connection():
    return mysql.connector.connect(
        host=Config.MYSQL_HOST,
        user=Config.MYSQL_USER,
        password=Config.MYSQL_PASSWORD,
        database=Config.MYSQL_DB
    )

def get_all_projects():
    connection = get_connection()
    cursor = connection.cursor(dictionary=True)
    cursor.execute("SELECT * FROM proyecto")
    results = cursor.fetchall()
    cursor.close()
    connection.close()
    return results

def get_all_subsistemas():
    connection = get_connection()
    cursor = connection.cursor(dictionary=True)
    cursor.execute("SELECT * FROM subsistema")
    results = cursor.fetchall()
    cursor.close()
    connection.close()
    return results

def get_all_documentos():
    connection = get_connection()
    cursor = connection.cursor(dictionary=True)
    cursor.execute("SELECT * FROM documento")
    results = cursor.fetchall()
    cursor.close()
    connection.close()
    return results

def get_all_asociaciones():
    connection = get_connection()
    cursor = connection.cursor(dictionary=True)
    cursor.execute("SELECT * FROM asociaciones")
    results = cursor.fetchall()
    cursor.close()
    connection.close()
    return results
