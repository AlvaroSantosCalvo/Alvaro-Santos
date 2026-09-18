# ---VARIABLES---
print("---VARIABLES---\n")
message1 = "Hola"
message2 = "Python"
full_message = f"{message1} {message2}"
x,y,z = 1,2,3
print(full_message.upper())
print(x,y,z)
print(4/2)
num = 1_500_874
print("\t", num)
def micasa():
    calle = "calle uno"
    piso = 6
    ascensor = True
variable = 3

# ---LISTAS---
print("\n---LISTAS---\n")

lista = []
print ("lista:",lista)
lista_valores = [1,2,3,5,9,2,5,4]
print ("lista_valores:",lista_valores)
lista_copy = lista_valores.copy()
print("lista_copy:",lista_copy)
lista_range = list(range(10))
print ("lista_range:",lista_range)
lista_repeticion = [0] * 10
print("lista_repetición:",lista_repeticion)

print("longitud de lista_valores:",len(lista_valores))
valor_uno = lista_valores[0]
print ("posicion 1 de lista_valores:",valor_uno) 
lista.append(2)
print("nueva lista:",lista)
print("sublista:", lista_range[0:4])
lista_range.append(10)
print ("añadir 10 a lista_range:",lista_range)
lista_range.insert(10, 9.5)
print ("añadir 9.5 a lista_range:",lista_range)
lista_range.pop()
print ("quitar último número de lista_range:",lista_range)

# ---FUNCIONES---
print("\n---FUNCIONES---\n")

def f(x):
    return 2*x
y=f(3), print(y)

def di_hola(nombre):
    print("Hola", nombre)
di_hola("Juan")

def resta(a, b):
    return a-b
print(resta(5, 3))

def suma(a, b, c=0):
    return a+b+c
print(suma(5,7,3))

def sumaFor(numeros):
    total = 0
    for n in numeros:
        total += n
    return total
print(sumaFor([1,3,5,4]))

def suma_y_media(a, b, c):
    """Descripción de la función:
    Hace la suma y la media de tres números"""
    suma = a+b+c
    media = suma/3
    return suma, media
suma, media = suma_y_media(9, 6, 3)
print(suma) # 18
print(media) # 6.0
help(suma_y_media)