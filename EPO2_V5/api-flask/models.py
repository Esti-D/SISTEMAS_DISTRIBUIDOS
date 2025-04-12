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

def buscar_id_proyecto_por_nombre(nombre_proyecto):
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute("SELECT id_pro FROM proyecto WHERE nombre_pro = %s", (nombre_proyecto,))
    result = cursor.fetchone()
    cursor.close()
    connection.close()
    return result[0] if result else None

def guardar_documento(nombre_doc, id_pro):
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute(
        "INSERT INTO documento (nombre_doc, id_pro) VALUES (%s, %s)",
        (nombre_doc, id_pro)
    )
    connection.commit()
    cursor.close()
    connection.close()

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
