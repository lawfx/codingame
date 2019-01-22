#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {
	
	int width, height, cols;
	std::cin >> width >> height;
	cols = (width - 1) / 3 + 1;

	std::vector<std::vector<char>> starts(2);
	std::vector<std::vector<int>> map(height - 2);

	starts[0].resize(cols);
	starts[1].resize(cols);

	for (int i = 0; i < cols; i++) {
		std::cin >> starts[0][i];
	}

	for (int i = 0; i < height - 2; i++) {
		map[i].resize(cols);
		int colIndex = 0;
		char part;
		std::cin >> part;
		while (colIndex < cols) {
			if (part == '|') {
				colIndex++;
			}
			else if (part == '-') {
				std::cin.ignore(1);
				map[i][colIndex - 1] = 1;
				map[i][colIndex] = -1;
			}

			if (colIndex < cols) {
				std::cin >> part;
			}
		}
	}

	for (int i = 0; i < cols; i++) {
		std::cin >> starts[1][i];
	}

	for (int i = 0; i < cols; i++) {
		std::cout << starts[0][i];
		
		int currLine = i;
		for (int j = 0; j < height - 2; j++) {
			currLine += map[j][currLine];
		}
		std::cout << starts[1][currLine] << std::endl;
	}
}
