def fibonacci(n,m):
    sucesionFBN = []
    for i in range(10):
        sucesion = n + m
        sucesionFBN.append(sucesion)
        n = m
        m = sucesion
    return sucesionFBN
sucesionFBN = fibonacci(0,1)
print("\n", sucesionFBN)