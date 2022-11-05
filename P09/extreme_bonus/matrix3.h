#include <vector>
#include <iostream>

class Matrix3
{
private:
    std::vector<std::vector<int>> data;

public:
    Matrix3();
    Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22);
    int get(int x, int y);
    Matrix3 operator+(Matrix3 rhs);
    Matrix3 operator*(int rhs);
    friend Matrix3 operator*(int lhs, Matrix3 rhs);
    friend std::ostream& operator<<(std::ostream& os, const Matrix3& m);
    friend std::istream& operator>>(std::istream& is, Matrix3& m);
    std::vector<int> operator[](int n);
};
