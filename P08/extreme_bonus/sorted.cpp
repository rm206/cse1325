#include <iostream>
#include <cstdlib>
#include <vector>
#include <algorithm>

int main()
{
    std::vector<std::string> v;
    std::string str;

    while(std::getline(std::cin >> std::ws, str) && str.length())
    {
        v.push_back(str);
    }

    std::sort(v.begin(), v.end());

    std::cout<<'\n'<<'\n';
    for(auto curr : v)
        std::cout << curr << '\n';

    return EXIT_SUCCESS;
}