# using GNU Aspell checker library and Rospell dictionary

import re
import enchant
import enchant.checker

default_path = r'D:\Facultate\an 3 sem 1\AI\AI Spellchecker\AI Spellchecker\fisier.txt'
output_path = r'D:\Facultate\an 3 sem 1\AI\AI Spellchecker\AI Spellchecker\corectat.txt'
new_dict = r'D:\Facultate\an 3 sem 1\AI\AI Spellchecker\AI Spellchecker\nou_dict.txt'
default_dictionary = r'D:\Facultate\an 3 sem 1\AI\AI Spellchecker\AI Spellchecker\lista-ro.txt'
ee = enchant.DictWithPWL("ro_RO", default_dictionary)
chkr = enchant.checker.SpellChecker("ro_RO")


def file_contents(path):
    with open(path, 'r', encoding="utf-8") as content_file:
        return content_file.read()


def update_dict(path=default_dictionary):
    dictionary = set(file_contents(path).split())
    add_to_dict(dictionary)
    print("Dictionary updated with", len(dictionary), "words.")


def add_to_dict(dict):
    d = enchant.Dict("ro_RO")
    for i, element in enumerate(list(dict)):
        if not d.check(element):
            d.add(element)
        print('Element', i, 'out of', len(list(dict)))


def remove_from_dict(dict):
    d = enchant.Dict("ro_RO")
    for element in list(dict):
        d.remove(element)


def write_to_file(path,text):
    with open(path, 'w',encoding="utf-8") as content_file:
        content_file.write(text)


def salvare_dictionar_txt(path,dictionary):
    write_to_file(path, "".join(element+"\n" for element in sorted(list(dictionary))))


def correct_punctuation_order(text):
    result = re.sub(r"([\w/'+$\s-]+|[^\w/'+$\s-]+)\s*", r"\1 ", text)
    return re.sub(r'\s+([?.,:;!"])', r'\1', result)


def correct_text(path=default_path, out_path=output_path,auto=True):
    text = file_contents(path)
    chkr.set_text(text)
    if auto is False:
        print("In textul:\n"+text+"\n")
        for error in chkr:
            x = error.wordpos
            print("In secventa '"+text[max(0,x-20):min(x+len(error.word)+20,len(text)-1)].replace('\n',' ')+"'")
            print("Pentru cuvantul "+error.word+":")
            sugestii = error.suggest()
            for i, suggestion in enumerate(sugestii):
                    print(str(i)+":", suggestion, end=", ")
            maxim = len(sugestii)
            print(str(maxim)+":", "Alta varianta.")
            print("")
            varianta = -1
            while varianta < 0 or varianta > maxim:
                varianta = int(input("Alege varianta\n"))
            if varianta < maxim:
                error.replace(sugestii[varianta])
            else:
                corect = input("Introduceti cuvantul corect:\n")
                error.replace(corect)
                chkr.add(corect)
    else:
        for error in chkr:
            sugestii = error.suggest()
            if len(error.word)>10:
                chkr.add(error.word)
            else:
                error.replace(sugestii[0])
    text = chkr.get_text()
    print(text)
    write_to_file(out_path, text)


if __name__ == "__main__":
    # update_dict()
    # correct_text()
    with open(r"D:\Facultate\an 3 sem 1\AI\AI Spellchecker\AI Spellchecker\1.hic procese expansive hidrocefalie 2012_corr.doc","r",encoding="utf-8") as content:
        print(content.read())