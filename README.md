# java-programs
Foundation: Numeric & Text

Text processing utilities:

    Basic search:
    [x] SEARCH_WORD: Find word positions / Check word is in file
    [x] SEARCH_SEGMENT: Show start-stop lines from text file
    Basic generate:
    [x] FILL_TEXT: Repeat a string n times
    Basic analyze:
    [x] WORD_COUNTER: Word counter
    [x] PASSWORD_COMPARE: Evaluate password strength
        - lungime min
        - min 1 caracter special
        - min 1 majuscula, 1 minuscula
        - min 1 cifra
    Basic processing:
    [x] CAMEL_TRANSFORM: Transform string into camel case identifier
        "random access identifier" -> "RandomAccessIdentifier"
    [x] SLUG_TRANSFORM: Transform string into slug
        "Your family dog's secrets" -> "your-family-dogs-secrets"

    Intermediate search:
    [x] SEARCH_STRING: Find string or longest fragment of it in file (longest common substring)
    Intermediate generate:
    [x] GENERATE_TEXT: Markov chain text generation (chain in a separate file)
    Intermediate analyze:
    [x] STATS_FREQUENCY: Word frequency for all words, shown in order from most frequent
    Intermediate processing:
    [x] STRING_REPLACE: Redact strings (replace substrings)
    [x] STRING_ENCRYPT: Caesar's cipher
    [x] STRING_NORMALIZE: Dedent string (split by newline, trim with first line's space count)

    Advanced search:
    [x] SEARCH_DATE: Find strings matching date format
        %YYYY : 2022, 2023, ...
    [x] SEARCH_REGEX: Find strings matching regex format
        /un [cC]uvant/
    Advanced generate:
    [x] GENERATE_TEMPLATE: Replace template markers of file and write new file
        {{variabilaMea}}
    Advanced analyze:
    [x] STATS_MARKOV: Extract markov chain from a body of text files
    Advanced processing:
    [x] STRING_REWRITING_SYSTEM: Markov's algorithm
        Reguli:
        a b c d -> a
        b c -> d
        Text:
        a a b c b c
        Rewriting:
        a a b c b c -> a a d b c
        a a d b c -> a a d d
        Result:
        a a d d

    Tech:
    [*] String class
    [*] Concatenation, splitting
    [*] Search, replace
    [*] StringBuilder class
    [*] String formatting
    [*] Regex patterns
    [*] UTF-8 and ASCII charsets
