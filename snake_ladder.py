import random
# print(random.randint(1,6)) # dice fun
def ThrowDice():
    return random.randint(1,6)
#simple game , two player , sum up th scores, who gets to 100 first win the game

def showScore(player1,player2):
    print("player 1 : ",player1)
    print("player 2 : ",player2)

def snakeBite(player):
    snake = {8:4,18:1,26:10,39:5,51:6,60:23,75:28,83:45,85:59,90:48,92:25,97:87,99:63}
    bite = snake.get(player)
    if bite is None:
        return player
    else:
        print("Snnnnn... snake bite at {p}... venom is lowering your score to {b}".format(p=player,b=bite))
        return bite

def ladderClimb(player):
    ladder = {3:20,6:14,11:28,15:34,17:74,22:37,38:59,49:67,57:76,61:78,73:86,81:98,88:91}
    climb=ladder.get(player)
    if climb is None:
        return player
    else:
        print("Yeeeeeeeeeeeepppppppppppppyyyyyyyyyyy......... ladder found at {p}...powering up your score to {c}".format(p=player,c=climb))
        return climb


def main():
    player1 = 0
    player2 = 0
    while True:
        input("\nPlayer 1  turn press enter")
        turn = ThrowDice()
        print("\n player 1 Dice says  : ",turn)
        if player1+turn<=100:
            player1=player1+turn
            player1=snakeBite(player1)
            player1=ladderClimb(player1)
        else:
            print("\n wait your turn again>100,")
        showScore(player1,player2)

        if player1==100:
            print("Player 1 Wins the game")
            break

        # player 2
        
        input("\nPlayer 1  turn press enter")
        turn = ThrowDice()
        print("\n player 2 Dice says  : ",turn)
        if player2+turn<=100:
            player2=player2+turn
            player2=snakeBite(player2)
            player2=ladderClimb(player2)
        else:
            print("\n this makes score>100,")
        showScore(player1,player2)

        if player2==100:
            print("Player 2 Wins the game")
            break
main()



