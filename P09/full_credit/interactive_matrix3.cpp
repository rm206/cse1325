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
    std::cout << "\n" << m1 << "     +\n" << m2 << "      =\n" << m1 + m2 << std::endl;

    return EXIT_SUCCESS;
}
