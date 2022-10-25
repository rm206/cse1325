#include <iostream>
#include <cstdlib>
#include <algorithm>

int main(int argc, char *argv[])
{
    for(int i = 0 ; i < argc ; i++)
    {
        std::string temp {argv[i]};
        std::reverse(temp.begin(), temp.end());
        std::cout << temp << std::endl;
    }

    return EXIT_SUCCESS;
}