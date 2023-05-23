from lxml import etree
import mysql.connector
import os

# Llegir un arxiu XML
def read_xml(path):
   file = open(path, 'r', encoding='utf-8')
   string = file.read()
   file.close()
   return bytes(bytearray(string, encoding='utf-8'))

# Escriure un arxiu HTML
def write_html(path, html):
   file = open(path, 'w', encoding='utf-8')
   file.write(html)
   file.close()

# Importar datos de MySQL
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="1234",
  database="proyecto"
)

mycursor = mydb.cursor()
mycursor.execute("select * from battle_results order by battle_points desc LIMIT 10")
myresult = mycursor.fetchall()

mycursor.execute("select COLUMN_NAME from information_schema.columns where table_name = 'battle_results'and table_schema = 'proyecto' order by ordinal_position;")
myresult2 = mycursor.fetchall()

xml=open("./xml/battle.xml", "w+")
xml.write('<?xml version="1.0" encoding="UTF-8"?>\n<battle>\n')

for x in myresult:
    xml.write(" <row>\n")
    for j, k in zip(x, myresult2):
        k = str(k).replace("(", "").replace(")", "").replace("'", "").replace(",", "")
        xml.write(f"    <{k}>{j}</{k}>\n")
    xml.write(" </row>\n")
xml.write("</battle>\n")

print(xml.read())
xml.close()


# Crear l'arbre XML
xml = read_xml('./xml/battle.xml')
xmlTree = etree.XML(xml)

xslFile = read_xml('./xml/template.xsl')
xslTree = etree.XML(xslFile)

transform = etree.XSLT(xslTree)
htmlDom = transform(xmlTree)

htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('UTF-8')
write_html("./html/index.html", htmlResult)