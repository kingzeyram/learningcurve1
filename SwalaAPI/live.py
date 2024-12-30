import flask
from flask import *
from flask_restful import Resource,Api
import pymysql

app = Flask(__name__)

#create api object
api = Api(app)
#next we create the data we want to shaare
class hardware(Resource):
    def get(self):
        #connecting to mysql database
        connect=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connect.cursor(pymysql.cursors.DictCursor)
        sq1="select * from hardware"
        cursor.execute(sq1)

        empData=cursor.fetchall()
        return jsonify(empData)
    def post(self):
        #Function to create hardware in our Allwarre
        #table name = hardware
        data = request.json
        #note colums exact as in db
        username=data['username']
        condition=data[ 'condition']
        budget=data['budget']
        type1=data['type']

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        sq1= "INSERT INTO hardware (username, conditions, budget, type) values (%s,%s,%s,%s)"
        try:
            cursor.execute(sq1,(username,condition,budget,type1))
            connection.commit()
            return {'success':'hardware added'}
        except:
            connection.rollback()
            return jsonify( {"message":"Post Failed"})

        return jsonify({'response':'Post Response'}) 
    
    def put(self):
        data = request.json
        #get data from api put request
        id_number=data["id_number"]
        budget=data['budget']

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        #sql query to update salary where id =passed
        sql="update hardware set budget =%s where id_number=%s"
        cursor.execute(sql,(budget,id_number))
        connection.commit()
        return jsonify( {'success':'Salary Updated'})

        
    def delete(self):
        data =request.json
        #delete data from api  delete request
        id_number=data["id_number"]

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        #Delete command
        sql=" delete from hardware  where id_number = %s"

        cursor.execute(sql, id_number)
        connection.commit()
        
        return jsonify({'Delete':"Deleted successfully"})

                 

api.add_resource(hardware,'/hardware') 

class software(Resource):
    def get(self):
        #connecting to mysql database
        connect=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connect.cursor(pymysql.cursors.DictCursor)
        sq1="select * from software"
        cursor.execute(sq1)

        empData=cursor.fetchall()
        return jsonify(empData)
    def post(self):
        #Function to create hardware in our Allwarre
        #table name = hardware
        data = request.json
        #note colums exact as in db
        username=data['username']
        condition=data[ 'condition']
        budget=data['budget']
        type=data['type']

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        sq1= "INSERT INTO software (username, conditions, budget, type) values (%s,%s,%s,%s)"
        try:
            cursor.execute(sq1,(username,condition,budget,type))
            connection.commit()
            return {'success':'software added'}
        except:
            connection.rollback()
            return jsonify( {"message":"Post Failed"})

        return jsonify({'response':'Post Response'}) 
    
    def put(self):
        data = request.json
        #get data from api put request
        id_number=data["id_number"]
        budget=data['budget']

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        #sql query to update salary where id =passed
        sql="update software set budget =%s where id_number=%s"
        cursor.execute(sql,(budget,id_number))
        connection.commit()
        return jsonify( {'success':'Salary Updated'})

        
    def delete(self):
        data =request.json
        #delete data from api  delete request
        id_number=data["id_number"]

        connection=pymysql.connect(host="lungaho1.mysql.pythonanywhere-services.com",user="lungaho1",password="April172005",database="lungaho1$default")
        cursor=connection.cursor()
        #Delete command
        sql=" delete from software  where id_number = %s"

        cursor.execute(sql, id_number)
        connection.commit()
        
        return jsonify({'Delete':"Deleted successfully"})

                 

api.add_resource(software,'/software') 







if __name__ =="__main__": 
    app.run(host='lungaho1.mysql.pythonanywhere-services.com', debug=True)                 
