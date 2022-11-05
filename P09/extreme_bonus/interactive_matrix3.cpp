// Interactive Matrix3 Tester
//
// This streams in two matrices and then streams out their sum

#include "matrix3.h"
#include <cstdlib>
#include <iostream>

int main() 
{
    Matrix3 m1, m2;
    std::cout << "Enter two 3x3 matrices:" << std::endl;
    std::cin >> m1 >> m2;
    std::cout << '\n' << m1 << "     +\n" << m2 << "=\n" << m1 + m2 << '\n';
    std::cout << '\n' << m1 << "  * 2 = \n" << m1 * 2 << '\n';
    std::cout << '\n' << m1 << "  * 2 = \n" << 2 * m2 << '\n';
    std::cout << "m1 with [][]: \n";
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            std::cout << m1[i][j] << " ";
        }

        std::cout << '\n';        
    }

    std::cout << "m2 with [][]: \n";
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            std::cout << m2[i][j] << " ";
        }

        std::cout << '\n';        
    }

    return EXIT_SUCCESS;
}