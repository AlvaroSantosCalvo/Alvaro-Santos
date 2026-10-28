
valor_1 : str = "Cadena de texto"
valor_2 : int = 1
valor_3 : float = 3.14
valor_4 : bool= True
valor_5 : list = []
valor_6 : dict = {}
print(type(valor_1))
print(type(valor_2))
print(type(valor_3))
print(type(valor_4))
print(type(valor_5))
print(type(valor_6))

#(Opcional)
#se indica el retorno con ->
#void ahora es None
def say_hello() -> None:
    print("Hello !")

def say_my_name(name):
    print("Hello", name, "!")
    print(f"Hello {name} !")

def count_my_letters(name : str) -> int:
    return len(name)

def my_full_name(name, surname, surname2="_"):
    print(f"My name is {name} {surname} {surname2}")

def create_player(name, type, type2="", hp=0, atk=0, fdef=0, satk=0, sdef=0, vel=0):
    print(f"Pokémon : {name}\nTipos  : {type}, {type2}")
    print(f"STATS:")
    print(f"HP : {hp}\nATK : {atk}\nSATK : {satk}\nDEF : {fdef}\nSDEF : {sdef}\nSPEED : {vel}")

def suma_lista(lista):
    suma=0
    for i in lista:
        suma += i
    return suma


#(opcional) -> metodo main() de JAVA
#lo que se ejecuta al darle a RUN
if __name__ == "__main__":
    print("hola")

    say_hello()

    say_my_name("Álvaro")

    i = count_my_letters("Álvaro")
    print(i)

    my_full_name("Álvaro", "Santos", "Calvo")
    my_full_name(name="Álvaro", surname="Santos")
    my_full_name(surname="Santos", name="Álvaro")

    create_player("pikachu", "Eléctrico", 34)

    mi_lista = [2,3,4,2]
    suma = suma_lista(mi_lista)
    print(suma)

    mi_lista_nombres = ["Dani", "Otro"]
    print(mi_lista_nombres)

    #Hay que comprobar si existe para poder borrarlo
    nombre = "Paco"
    if nombre in mi_lista_nombres:
        mi_lista_nombres.remove(nombre)
    else:
        print("El nombre no está en la lista")
    print(mi_lista_nombres)