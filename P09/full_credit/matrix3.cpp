#include "matrix3.h"

Matrix3::Matrix3() : data{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}{}

Matrix3::Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22)
    : data{{m00, m01, m02}, {m10, m11, m12}, {m20, m21, m22}}
{
}

int Matrix3::get(int x, int y)
{
    if (x < 0 || y < 0 || x > 2 || y > 2)
        throw std::runtime_error{"index out of bounds error"};
        
    return data[x][y];
}

std::ostream &operator<<(std::ostream &os, const Matrix3 &m)
{
    for (int i = 0 ; i < m.data.size() ; i++)
    {
        for (int j = 0 ; j < m.data[0].size() ; j++)
            os << m.data[i][j] << " ";
        os << "\n";
    }

    return os;
}

Matrix3 Matrix3::operator+(Matrix3 rhs)
{
    Matrix3 newM3;
    for (int i = 0 ; i < this->data.size() ; i++)
        for (int j = 0 ; j < this->data[0].size() ; j++)
            newM3.data[i][j] = this->data[i][j] + rhs.data[i][j];
    
    return newM3;
}

std::istream& operator>>(std::istream& is, Matrix3& m)
{
    is >> m.data[0][0];
    is >> m.data[0][1];
    is >> m.data[0][2];
    is >> m.data[1][0];
    is >> m.data[1][1];
    is >> m.data[1][2];
    is >> m.data[2][0];
    is >> m.data[2][1];
    is >> m.data[2][2];

    return is;
}