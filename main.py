from tkinter import *
from tkinter.tix import *
from os import path
from os import system
import pickle

window = Tk()
window['bg'] = "grey"
window.title("Ukrainian High-Tech Encoder Program")
window.iconbitmap("ico.ico")
window.geometry('750x500')
window.resizable( width = False, height = False)

program_mode = StringVar()
program_mode.set("Crypt")
chose_alg = IntVar()
chose_alg.set(1)

canvas = Canvas(window, width = 800, height = 500)
canvas.pack()

frame = Frame(window, bg = 'grey79')
frame.place(relx = 0.025, rely = 0.05, relwidth = 0.525, relheight = 0.9)
label_input = Label(frame, text = 'Input:')
label_input.place(relx = 0.0536, rely = 0.028, relwidth = 0.3, relheight = 0.051)
textInput = Text(frame)
textInput.place(relx = 0.0525, rely = 0.08, relwidth = 0.9, relheight = 0.25 )
label_output = Label(frame, text = 'Output:')
label_output.place(relx = 0.0535, rely = 0.35, relwidth = 0.3, relheight = 0.051)
textOutput = Text(frame, width = 44, height = 5)
textOutput.place(relx = 0.0525, rely = 0.4, relwidth = 0.9, relheight = 0.25)

label1_1 = Label(frame, text = 'Key 1:')
label1_1.place(relx = 0.051, rely = 0.67)
key1 = Entry(frame)
key1.place(relx = 0.2, rely = 0.67, relwidth = 0.59, relheight = 0.05)
label1_2 = Label(frame, text = 'Key 2:')
label1_2.place(relx = 0.051, rely = 0.75)
key2 = Entry(frame, state = DISABLED )
key2.place(relx = 0.2, rely = 0.75, relwidth = 0.59, relheight = 0.05)
ttp_1 = Balloon(window)
ttp_2 = Balloon(window)
ttp_1.bind_widget(key1, balloonmsg = "Int Key")
ttp_2.bind_widget(key2, balloonmsg = "Int key")

def btn_execute():
    key_1_msg = '1'
    key_2_msg = '12'
    if key1.get():
        key_1_msg = key1.get()
    if key2.get():
        key_2_msg = key2.get()
    
    f = open("cryptoData.crypt", 'w')
    query ="java -jar UHTEP.jar "+"\"" + path.abspath("cryptoData.crypt") + "\" " + program_mode.get() + " " + str(chose_alg.get())
    filetext = f.write(textInput.get('1.0', END) + key_1_msg + "\n" + key_2_msg)
    f.close()
    system(query)
    f = open("cryptoData.crypt", "r")
    textOutput.delete('1.0', END)
    textOutput.insert(1.0, f.readline())
    f.close()
    os.remove(path.abspath("cryptoData.crypt"))

buttonExecute = Button(frame, text = 'Execute', width=15, height=3, bg='green', command = btn_execute)
buttonExecute.place(relx = 0.15, rely = 0.84)

def btn_clear():
    textInput.delete('1.0', END)
    textOutput.delete('1.0', END)
buttonClear = Button(frame, text = 'Clear', width=15, height=3, command = btn_clear)
buttonClear.place(relx = 0.55, rely = 0.84)

frame_change = Frame(window, bg = 'grey79')
frame_change.place(relx = 0.58, rely = 0.05, relwidth = 0.395, relheight = 0.1)
radio_Crypt = Radiobutton(frame_change ,text = 'Crypt message', variable = program_mode, value = 'Crypt')
radio_Decrypt = Radiobutton(frame_change ,text = 'Decrypt message', variable = program_mode, value = 'Decrypt')
radio_Crypt.place(relx = 0.05, rely = 0.3)
radio_Decrypt.place(relx = 0.53, rely = 0.3)

def radio_event():
    if chose_alg.get() == 7:
        key2['state'] = NORMAL
    else:
        key2['state'] = DISABLED
    if chose_alg.get() == 1 or chose_alg.get() == 4 or chose_alg.get() == 5 or chose_alg.get() == 7 or chose_alg.get() == 8:
        ttp_1.bind_widget(key1, balloonmsg = "Int Key")
    else:
        ttp_1.bind_widget(key1, balloonmsg = "String Key")

frame_alg = Frame(window, bg = 'grey79')
frame_alg.place(relx = 0.58, rely = 0.15, relwidth = 0.395, relheight = 0.8)
label1 = Label(frame_alg, text = 'Roll methods:')
label1.place(relx = 0.05, rely = 0.04, relwidth = 0.9)
radio_Roll_1 = Radiobutton(frame_alg, text = 'Caesar', bg = 'grey79', variable = chose_alg, value = 1, command = radio_event)
radio_Roll_1.place(relx = 0.05, rely = 0.12)
radio_Roll_2 = Radiobutton(frame_alg, text = 'Diogens', bg = 'grey79', variable = chose_alg, value = 2, command = radio_event)
radio_Roll_2.place(relx = 0.05, rely = 0.2)
radio_Roll_3 = Radiobutton(frame_alg, text = 'Socrates', bg = 'grey79', variable = chose_alg, value = 3, command = radio_event)
radio_Roll_3.place(relx = 0.05, rely = 0.28)
label2 = Label(frame_alg, text = 'Replace methods:')
label2.place(relx = 0.05, rely = 0.36, relwidth = 0.9)
radio_Rep_1 = Radiobutton(frame_alg, text = 'ID', bg = 'grey79', variable = chose_alg, value = 4, command = radio_event)
radio_Rep_1.place(relx = 0.05, rely = 0.44)
radio_Rep_2 = Radiobutton(frame_alg, text = 'Itajara', bg = 'grey79', variable = chose_alg, value = 5, command = radio_event)
radio_Rep_2.place(relx = 0.05, rely = 0.52)
label3 = Label(frame_alg, text = 'Combined methods:')
label3.place(relx = 0.05, rely = 0.6, relwidth = 0.9)
radio_Com_1 = Radiobutton(frame_alg, text = 'Super ID', bg = 'grey79', variable = chose_alg, value = 6, command = radio_event)
radio_Com_1.place(relx = 0.05, rely = 0.68)
radio_Com_2 = Radiobutton(frame_alg, text = 'Heraklez', bg = 'grey79', variable = chose_alg, value = 7, command = radio_event)
radio_Com_2.place(relx = 0.05, rely = 0.76)
radio_Com_3 = Radiobutton(frame_alg, text = 'APE', bg = 'grey79', variable = chose_alg, value = 8, command = radio_event)
radio_Com_3.place(relx = 0.05, rely = 0.84)

authors = Label(frame_alg, text = 'Made by Swonsonn and 愛てる\nTested by sup4\n\tStable version 1.1', bg = 'grey79')
authors.place(relx = 0.4, rely = 0.85)

window.mainloop()