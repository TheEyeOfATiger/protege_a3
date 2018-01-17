import enchant,io
d = enchant.Dict("ro_RO")
file_read = io.open("text.txt",mode = 'r',encoding="UTF-8")
string = file_read.read()
file_read.close()
def xsplit(string):
    print(string)
    big_list = []
    word_list = ""
    list = ""
    for letter in range(0,len(string)):
        if string[letter] in 'qwertyuiopasdfghjklzxcvbnmaîâ\u0219\u021BQWERTYUIOPASDFGHJKLZXCVBNMAÎÂ\u0218\u021A':
            list += string[letter]
        else:
            if(len(list) != 0):
                big_list.append(list)
            big_list.append(string[letter])
            word_list = word_list + " " + list
            list = ""
    return big_list,word_list.split()

def list_to_string(list):
    string = ""
    for element in list:
        string += element
    return string

def list_to_string_with_comma(list):
    string = ""
    for element in list:
        string += element + ", "
    return string[:len(string)-2]

big_list,string = xsplit(string)
wrong_words_list = []
wrong_words = ""
for word in string:
    if not d.check(word):
        wrong_words_list.append(word)
        wrong_words = wrong_words + ", " + word
wrong_words = wrong_words[2:]
if len(wrong_words_list) == 0:
    print("Textul nu are niciun cuvant gresit din punct de vedere gramatical")
else:
    print("Cuvintele urmatoare sunt gresite din punct de vedere gramatical: " + str(wrong_words))

    file_write = io.open("text.txt",mode= 'w',encoding="UTF-8")

    raspuns = input("Vrei sa se corecteze testul automat, sau manual: ")
    while raspuns != "automat" and raspuns != "manual":
        raspuns = input("Ai introdus un raspuns eronat, reincearca din nou: ")
    if raspuns == "automat":
        for wrong_word in wrong_words_list:
            for it in range(0,len(big_list)):
                if wrong_word == big_list[it]:
                    big_list[it] = d.suggest(wrong_word)[0]
        print("\nTextul rezultat dupa corectare: ")
        print(list_to_string(big_list))
        file_write.write(list_to_string(big_list))
    elif raspuns == "manual":
        print("\nPentru fiecare dintre cuvintele gresite alegeti sugestia dorita,pentru trecerea peste o corectare scrieti \"nu\"")
        for wrong_word in wrong_words_list:
            raspuns = input(wrong_word + " sugestii: " + list_to_string_with_comma(d.suggest(wrong_word))+": ")
            if(raspuns == "nu"):
                continue
            else:
                for it in range(0,len(big_list)):
                    if wrong_word == big_list[it]:
                        big_list[it] = raspuns
        print("\nTextul rezultat dupa corectare: ")
        print(list_to_string(big_list))
        file_write.write(list_to_string(big_list))
