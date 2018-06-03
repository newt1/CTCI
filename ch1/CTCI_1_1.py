#determines whether a given string has all unique characters
def isUnique(string):
    return len(set(string)) == len(string)
