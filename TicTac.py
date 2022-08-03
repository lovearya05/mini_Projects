import random
board = [' ' for x in range(10)]


def printBoard(board):
    print('   |   |   ')
    print(' ' + board[1] + ' | ' + board[2] + ' | ' + board[3])
    print('   |   |   ')
    print('------------')
    print('   |   |   ')
    print(' ' + board[4] + ' | ' + board[5] + ' | ' + board[6])
    print('   |   |   ')
    print('------------')
    print('   |   |   ')
    print(' ' + board[7] + ' | ' + board[8] + ' | ' + board[9])
    print('   |   |   ')

def spaceIsFree(pos):
    return board[pos]==' '

def insertLetter(letter,pos):
    board[pos]=letter

def isBoardFull(board):
    if board.count(' ') > 1:
        return False
    else:
        return True

def IsWinner(b,l):
    return (b[1]== l and b[2]==l and b[3]==l) or (b[4]== l and b[5]==l and b[6]==l) or \
    (b[7]== l and b[8]==l and b[9]==l) or \
    (b[1]== l and b[4]==l and b[7]==l) or (b[3]== l and b[6]==l and b[9]==l) or \
    (b[2]== l and b[5]==l and b[8]==l) or \
    (b[1]== l and b[5]==l and b[9]==l) or (b[3]== l and b[5]==l and b[7]==l)
    
def playerMove(symbol):
    run = True
    while run:
        move = input("please select a position to enter the {sym} between 1 to 9".format(sym=symbol))
        try:
            move = int(move)
            if move > 0 and move < 10:
                if spaceIsFree(move):
                    run = False
                    insertLetter(symbol , move)
                else:
                    print('Sorry, this space is occupied')
            else:
                print('please type a number between 1 and 9')

        except:
            print('Please type a number')

def AI_player_turn(my_symbol, opp_symbol):
    #check own winning conditions
    #rows
    print("\nAI Player Turn:\n")
#columns
#block opponent
#block rows
#block diagonals
#diagonals
# else return random
    run = True
    while run:
        place = defeatChance('O')

        # print(place)
        if spaceIsFree(place):
            return place
        else:
            AI_player_turn(my_symbol, opp_symbol)
        


def defeatChance(os):
    if(board[1]==os and board[2]==os): 
        if spaceIsFree(3): return 3
    if(board[4]==os and board[5]==os): 
        if spaceIsFree(6): return 6
    if(board[7]==os and board[8]==os): 
        if spaceIsFree(9): return 9
    if(board[1]==os and board[3]==os): 
        if spaceIsFree(2): return 2
    if(board[4]==os and board[6]==os): 
        if spaceIsFree(5): return 5
    if(board[7]==os and board[9]==os): 
        if spaceIsFree(8): return 8
    if(board[2]==os and board[3]==os): 
        if spaceIsFree(1): return 1
    if(board[6]==os and board[5]==os): 
        if spaceIsFree(4): return 4
    if(board[8]==os and board[9]==os): 
        if spaceIsFree(7): return 7
    if(board[1]==os and board[4]==os): 
        if spaceIsFree(7): return 7
    if(board[2]==os and board[5]==os): 
        if spaceIsFree(8): return 8
    if(board[3]==os and board[6]==os): 
        if spaceIsFree(9): return 9
    if(board[4]==os and board[7]==os): 
        if spaceIsFree(1): return 1
    if(board[5]==os and board[8]==os): 
        if spaceIsFree(2): return 2
    if(board[6]==os and board[9]==os): 
        if spaceIsFree(3): return 3
    if(board[1]==os and board[7]==os): 
        if spaceIsFree(4): return 4
    if(board[2]==os and board[8]==os): 
        if spaceIsFree(5): return 5
    if(board[3]==os and board[9]==os): 
        if spaceIsFree(6): return 6
    
    if(board[1]==os and board[5]==os): 
        if spaceIsFree(9): return 9
    if(board[3]==os and board[5]==os): 
        if spaceIsFree(7): return 7
    if(board[7]==os and board[5]==os): 
        if spaceIsFree(3): return 3
    if(board[5]==os and board[9]==os): 
        if spaceIsFree(1): return 1

    t = random.randint(1,9)

    return t
    

def main():
    print("Welcome to the Tic Tac Toe game\nHuman Player: O\nAI Player: X\n")
    printBoard(board)
    while(True):
        playerMove('O')
        printBoard(board)
        if IsWinner(board,'O'):
            print("\nWinner is Human Player O")
            break
        elif isBoardFull(board):
            print("\n Game Tied")
            break
        
        x=AI_player_turn('X','O')
        insertLetter('X',x)
        printBoard(board)
        if IsWinner(board,'X'):
            print("\nWinner is AI Player X")
            break
        elif isBoardFull(board):
            print("\n Game Tied")
            break

main()