def calculate_calories_and_coins(screen):
    M, N = len(screen), len(screen[0])
    coins = 0
    calories = 0
    
    for col in range(N):
        max_coin_height = -1
        ring_hurdle_height = -1
        jump_height = 0
        
        for row in range(M):
            if screen[row][col] == 'C':
                max_coin_height = max(max_coin_height, row)
            elif screen[row][col] == 'H':
                if ring_hurdle_height == -1:
                    ring_hurdle_height = row
                else:
                    jump_height = max(jump_height, row - ring_hurdle_height - 1)
                    ring_hurdle_height = row
        
        coins += max_coin_height + 1
        calories += 2 * jump_height
    
    return coins, calories

# Read input
M, N = map(int, input().split())
screen = [input().strip() for _ in range(M)]

coins, calories = calculate_calories_and_coins(screen)
print(coins, calories)
