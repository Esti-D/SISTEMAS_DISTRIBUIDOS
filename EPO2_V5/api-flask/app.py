from flask import Flask, jsonify
import requests

from models import (
    get_all_projects,
    get_all_subsistemas,
    get_all_documentos,
    get_all_asociaciones
)

app = Flask(__name__)

@app.route('/api/proyectos', methods=['GET'])
def obtener_proyectos():
    proyectos = get_all_projects()
    return jsonify(proyectos)

@app.route('/api/subsistemas', methods=['GET'])
def obtener_subsistemas():
    subsistemas = get_all_subsistemas()
    return jsonify(subsistemas)

@app.route('/api/documentos', methods=['GET'])
def obtener_documentos():
    documentos = get_all_documentos()
    return jsonify(documentos)

@app.route('/api/asociaciones', methods=['GET'])
def obtener_asociaciones():
    asociaciones = get_all_asociaciones()
    return jsonify(asociaciones)

@app.route('/pokemon/<nombre>', methods=['GET'])
def obtener_pokemon(nombre):
    url = f'https://pokeapi.co/api/v2/pokemon/{nombre.lower()}'
    try:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()

        resultado = {
            "name": data["name"],
            "type": data["types"][0]["type"]["name"],
            "image": data["sprites"]["front_default"]
        }

        return jsonify(resultado)

    except requests.exceptions.HTTPError:
        return jsonify({"error": "Pokémon no encontrado"}), 404
    except Exception as e:
        return jsonify({"error": f"Error al obtener Pokémon: {str(e)}"}), 500


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
