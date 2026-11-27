import sys
import pygame

class AlienInvasion:
    """Clase general para gestionar lo recursos y el juego."""
    
    def __init__(self):
        """Inicializa el juego y crea recursos."""
        pygame.init()
        #self.clock = pygame.time.Clock()
        
        self.screen = pygame.display.set_mode((1200, 800))
        pygame.display.set_caption("Alien Invasion")

    def run_game(self):
        """Inicializa bucle principal para el juego."""
        while True:
            #Busca eventos de teclado y ratón.
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()

            #Hace visible la última pantalla dibujada
            pygame.display.flip()
            
if __name__ == '__main__':
    #Hace una instancia del juego y lo ejecuta
    ai = AlienInvasion()
    ai.run_game()