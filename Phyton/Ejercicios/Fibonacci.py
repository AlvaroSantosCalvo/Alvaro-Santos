""" ---Mi Solución--- """
sucesionFBN = []
def fibonacci(n,m):   
    for i in range(10):
        sucesion = n + m
        sucesionFBN.append(str(sucesion))
        n = m
        m = sucesion
    return sucesionFBN
sucesionFBN = fibonacci(0,1)
print("\n", sucesionFBN)

""" ---Primera Solución--- """
sucesionFBN2=[]
def fibonacci2(n):
    if n <= 1:
        return n
    else:
        return fibonacci2(n-1) + fibonacci2(n-2)

for i in range(10):
    sucesionFBN2.append(str(fibonacci2(i)))

print("\n", sucesionFBN2)

""" ---Segunda solución--- """
n=10
a, b = 0, 1
sucesionFBN3 = []
for _ in range(n):
    sucesionFBN3.append(str(a))
    a, b = b, a + b
print("\n", sucesionFBN3)