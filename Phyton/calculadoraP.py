import tkinter as tk
from tkinter import ttk

root = tk.Tk()
root.title("Calculadora")
root.geometry("600x800")

root.columnconfigure(0, weight=1)
root.columnconfigure(1, weight=9)

opcion = ["Normal", "Científica"]
selected_option = tk.StringVar(root)
selected_option.set(opcion[0])
# Menú desplegable para modo normal o científica
menuOp = ttk.Combobox(root,
    textvariable=selected_option,
    values=opcion,
    state="readonly",
)
# Campo de texto para la pantalla de la calculadora
pantalla = tk.Entry(root, background="black", foreground="white")
pantalla.insert(0, "0")

# Añadir el menu y la pantalla a la primera 
menuOp.grid(row=0, column=0, sticky="nsew", padx=10, pady=10)
pantalla.grid(row=0, column=1, sticky="nsew", padx=10, pady=10)

# Contenedores para los botones de números y operadores
num_frame = tk.Frame(root)
ops_frame = tk.Frame(root)
num_frame.grid(row=1, column=0, sticky="nsew")
ops_frame.grid(row=1, column=1, sticky="nsew")

bNums = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"]
bOps = ["+", "-", "*", "/", "="]

for i, number in enumerate(bNums):
    row = i // 3
    col = i % 3
    button = tk.Button(num_frame, text=number, width=5, height=2)
    button.grid(row=row, column=col, padx=5, pady=5)

for i, operator in enumerate(bOps):
    button = tk.Button(ops_frame, text=operator, width=5, height=2)
    button.grid(row=i, column=0, padx=5, pady=5)

root.mainloop()