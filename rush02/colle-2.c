#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>

int h(char *buf);

int a(char *buf);

void	ft_putchar(char c);

void	ft_putnbr(int nb);

void ft_putchar(char c)
{
	write(1, &c, 1);
}

void	ft_putstr(char *str)
{
	int ind;
	
	ind = 0;
	while (str[ind] != '\0')
	{
		ft_putchar(str[ind]);
		ind++;
	}
}

int main(int col, char **args)
{
	int b;
	char buf[4097];

	b = read(0, buf, 4096);
	buf[b] = '\0';
	
	ft_putnbr(h(buf));
	ft_putchar('\n');
	ft_putnbr(a(buf));
	ft_putchar('\n');
	ft_putstr(buf);

	return (0);
}

int h(char *buf)
{
	int x;
	int i;

	i = 0;
	x = 0;
	while (buf[x] != '\0')
	{
		if (buf[x] == '\n')
			i++;
		x++;
	}
	return (i);
}

int a(char *buf)
{
	int x;

	x = 0;
	while (buf[x] != '\n')
	{
		x++;
	}
	return (x);
}

void	ft_putnbr(int nb)
{
	if (nb == -2147483648)
	{
		ft_putchar('-');
		ft_putchar('2');
		ft_putnbr(147483648);
	}
	else
	{
		if (nb < 0)
		{
			nb = nb * (-1);
		}
		else
		{
			if (nb < 10)
			{
				ft_putchar('0' + nb);
			}
			else
			{
				ft_putnbr(nb / 10);
				ft_putnbr(nb % 10);
			}
		}
	}
}



