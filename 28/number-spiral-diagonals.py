import math

class Grid:

    def __init__(self, size):
        self.size = size
        self.mid = math.floor(size / 2)
        self.cell = (self.mid, self.mid)
        self.val = 1
        self.len = 0
        self.grid = [[0 for i in range(self.size)] for j in range(self.size)]
        self.set_cell(self.cell)

    def set_cell(self, cell):
        self.grid[cell[0]][cell[1]] = self.val
        self.val = self.val + 1

    def print(self):
        print('\n'.join([''.join(['{:4}'.format(item) for item in row]) for row in self.grid]))

    def move_right(self):
        self.cell = (self.cell[0], self.cell[1] + 1)
        self.set_cell(self.cell)

    def move_left(self):
        self.cell = (self.cell[0], self.cell[1] - 1)
        self.set_cell(self.cell)

    def move_down(self):
        self.cell = (self.cell[0] + 1, self.cell[1])
        self.set_cell(self.cell)

    def move_up(self):
        self.cell = (self.cell[0] - 1, self.cell[1])
        self.set_cell(self.cell)

    def go_around(self):
        self.move_right()

        self.len = self.len + 1
        for _ in range(0, self.len):
            self.move_down()
        self.len = self.len + 1

        for _ in range(0, self.len):
            self.move_left()
        for _ in range(0, self.len):
            self.move_up()
        for _ in range(0, self.len):
            self.move_right()

    def fill(self):
        for _ in range(0, self.mid):
            self.go_around()

    def sum_diagonals(self):
        sum = 0
        for i in range(0, self.size):
            for j in range(0, self.size):
                if (i == j) or (i + j == self.size - 1):
                    sum = sum + self.grid[i][j]
        return sum


grid = Grid(1001)
# grid.print()
print("")

grid.fill()
# grid.print()
print("")
print(grid.sum_diagonals())
