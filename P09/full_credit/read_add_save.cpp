#include <iostream>
#include <cstdlib>
#include "matrix3.h"
#include <fstream>

int main(int argc, char *argv[])
{
    if (argc < 3)
        throw std::runtime_error{"Minimum 3 arguments required\nUsage: ./read_add_save {writeFile} [{inputFile}...]\n"};

    Matrix3 sumM3;
    Matrix3 temp;

    std::string writeFileName{argv[1]};
    std::ofstream ofs{writeFileName};
    if(!ofs)
        throw std::runtime_error{"Write file could not be opened"};

    for (int i = 2; i < argc; i++)
    {
        std::string inputFileName{argv[i]};
        std::ifstream ist{inputFileName};
        if(!ist)
            throw std::runtime_error{"Could not open " + inputFileName};

        ist>>temp;
        sumM3 = sumM3+temp;
    }

    std::cout << sumM3;
    ofs << sumM3;

    return EXIT_SUCCESS;
}