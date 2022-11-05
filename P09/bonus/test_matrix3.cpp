#include "matrix3.h"
#include <sstream>

bool equals(Matrix3 &lhs, Matrix3 &rhs)
{
    for (int y = 0; y < 3; ++y)
        for (int x = 0; x < 3; ++x)
            if (lhs.get(x, y) != rhs.get(x, y))
                return false;
    return true;
}

int main()
{
    int vector = 1;
    int result = 0;

    Matrix3 mi; // Should be all 0
    Matrix3 m0{
        0, 0, 0,
        0, 0, 0,
        0, 0, 0};
    if (!equals(mi, m0))
    {
        std::cerr << "ERROR: Default matrix not all 0:" << mi << std::endl;
        result |= vector;
    }

    // Negative and positive ints
    vector <<= 1;
    Matrix3 m1{
        1, 2, 3,
        4, 5, 6,
        7, 8, 9};
    Matrix3 m2{
        -1, 8, -15,
        11, -6, 0,
        0, 1, 0};
    Matrix3 m3{
        0, 10, -12,
        15, -1, 6,
        7, 9, 9};

    Matrix3 me = m1 + m2;

    if (!equals(me, m3))
    {
        std::cerr << "ERROR: Addition failed:" << m1 << "+" << m2
                  << "=" << me << "not" << m3 << std::endl;
        result |= vector;
    }

    vector <<= 1;

    std::istringstream iss{"8 14 3 -2 9 11 42 -19 81"};
    Matrix3 miss;
    iss >> miss;

    std::ostringstream oss;
    oss << miss;

    std::string expected = "8 14 3 \n-2 9 11 \n42 -19 81 \n";
    if (oss.str() != expected)
    {
        std::cerr << "ERROR: << or >> failed:\n'" << miss
                  << "'\n!=\n'" << expected << "'" << std::endl;
        std::cerr << "\n  (This may just be due to different spacing, which may vary)\n\n";
        result |= vector;
    }

    if (result)
        std::cerr << "FAIL: Error code " << result << std::endl;
    return result;
}
