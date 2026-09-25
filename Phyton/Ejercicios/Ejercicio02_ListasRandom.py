import random

quince=[]
n=1
for i in range(15):
    quince.append(str(n))
    n += 1
print(quince)

veinte=[]

m=1
while m<=20:
    veinte.append(str(m))
    m+=1
print(veinte)


"1.- Lista de 15 nº aleatorios enteros del 0 al 100 con FOR"
cadenaUno=[]
for _ in range(15):
    cadenaUno.append(random.randint(0, 100))
print("1.-", cadenaUno)

"2.- Lista de 13 nº decimales del 3 al 5 con WHILE"
cadenaDos=[]
while len(cadenaDos) < 13:
    cadenaDos.append(random.uniform(3,5))
print("2.-", [f"{numero:.2f}" for numero in cadenaDos])

"3.- Lista de 4 elementos aleatorios con valores (Izquirda, Derecha, Arriba y Abajo) con FOR"
cadenaTres=[]
for _ in range(4):
    cadenaTres.append(random.choice(["Izquierda", "Derecha", "Arriba", "Abajo"]))
print("3.-", cadenaTres)
