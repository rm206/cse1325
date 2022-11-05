// Interactive Matrix3 Tester
//
// This streams in two matrices and then streams out their sum

#include "matrix3.h"

int main() 
{
    Matrix3 m1, m2;
    std::cout << "Enter two 3x3 matrices:" << std::endl;
    std::cin >> m1 >> m2;
    std::cout << '\n' << m1 << "     +\n" << m2 << "=\n" << m1 + m2 << '\n';
    std::cout << '\n' << m1 << "  * 2 = \n" << m1 * 2 << '\n';
    std::cout << '\n' << m1 << "  * 2 = \n" << 2 * m2 << '\n';
}