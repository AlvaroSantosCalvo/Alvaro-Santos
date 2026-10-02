import tkinter as tk
from tkinter import ttk

root = tk.Tk()
root.title("Calculadora")
root.geometry("800x600")

opcion = ["Normal", "Científica"]
selected_option = tk.StringVar(root)
selected_option.set(opcion[0])

menuOp = ttk.Combobox(
    root,
    textvariable=selected_option,
    values=opcion,
    state="readonly",
)
menuOp.pack(pady=20)

main_frame = tk.Frame(root)
main_frame.pack(padx=20, pady=10)

# Panel de números: 3 columnas y 4 filas
num_frame = tk.Frame(main_frame)
num_frame.grid(row=0, column=0, padx=(0, 10))

# Panel de operadores: 1 columna a la derecha
ops_frame = tk.Frame(main_frame)
ops_frame.grid(row=0, column=1)

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

for col in range(3):
    num_frame.columnconfigure(col, weight=1)

for row in range(4):
    num_frame.rowconfigure(row, weight=1)

for row in range(len(bOps)):
    ops_frame.rowconfigure(row, weight=1)
ops_frame.columnconfigure(0, weight=1)

root.mainloop()