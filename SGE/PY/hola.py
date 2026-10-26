nombre = "Álvaro"
num1,num2 = 2,9
try:
    num3 = int(input("dame un número: "))
except ValueError:
    num3 = 0

#if(isinstance(int(num3),int)):
#    num3=int(num3)
#else:
#    num3=0

resultado = num1 + num2 + num3

try:
    print("Hola " + nombre + "\nSuma:" +str(resultado))
    """ print("Hola " + nombre + "\nSuma:" +num1+num2) <-Da error por no tener el str()"""
    print
except TypeError:
    print("Se ha producido un error.")
