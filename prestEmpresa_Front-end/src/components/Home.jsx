import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { ChevronRight, BarChart2, Users, Shield } from 'lucide-react';

export default function Home() {
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    setIsVisible(true);
  }, []);

  const fadeIn = {
    hidden: { opacity: 0, y: 20 },
    visible: { opacity: 1, y: 0 }
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-white">
      <main>
        <section className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20 text-center">
          <motion.h1
            className="text-5xl md:text-6xl font-extrabold mb-6 text-gray-800"
            initial="hidden"
            animate={isVisible ? "visible" : "hidden"}
            variants={fadeIn}
            transition={{ duration: 0.6 }}
          >
            Potencia tu empresa con <span className="text-blue-600">PrestEmpresa</span>
          </motion.h1>
          <motion.p
            className="text-xl text-gray-600 mb-10 max-w-3xl mx-auto"
            initial="hidden"
            animate={isVisible ? "visible" : "hidden"}
            variants={fadeIn}
            transition={{ duration: 0.6, delay: 0.2 }}
          >
            Optimiza tus operaciones, mejora la gestión y alcanza nuevos niveles de éxito con nuestras soluciones integrales de gestión empresarial.
          </motion.p>
          <motion.div
            initial="hidden"
            animate={isVisible ? "visible" : "hidden"}
            variants={fadeIn}
            transition={{ duration: 0.6, delay: 0.4 }}
          >
            <Link className="inline-flex items-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 md:py-4 md:text-lg md:px-10">
              Solicitar una demo
              <ChevronRight className="ml-2 -mr-1 h-5 w-5" aria-hidden="true" />
            </Link>
          </motion.div>
        </section>

        <section className="bg-gray-50 py-20">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <motion.h2
              className="text-3xl font-extrabold text-gray-900 text-center mb-12"
              initial="hidden"
              animate={isVisible ? "visible" : "hidden"}
              variants={fadeIn}
              transition={{ duration: 0.6 }}
            >
              Nuestras soluciones
            </motion.h2>
            <div className="mt-10">
              <div className="grid grid-cols-1 gap-10 sm:grid-cols-2 lg:grid-cols-3">
                {[
                  {
                    title: 'Gestión financiera',
                    description: 'Control total de tus finanzas con informes detallados y pronósticos precisos.',
                    icon: BarChart2,
                  },
                  {
                    title: 'Recursos humanos',
                    description: 'Optimiza la gestión de personal, nóminas y desarrollo de talento.',
                    icon: Users,
                  },
                  {
                    title: 'Seguridad y cumplimiento',
                    description: 'Garantiza la seguridad de tus datos y el cumplimiento normativo.',
                    icon: Shield,
                  },
                ].map((item, index) => (
                  <motion.div
                    key={item.title}
                    className="bg-white rounded-lg shadow-lg overflow-hidden"
                    initial="hidden"
                    animate={isVisible ? "visible" : "hidden"}
                    variants={fadeIn}
                    transition={{ duration: 0.6, delay: 0.1 * index }}
                  >
                    <div className="p-6">
                      <div className="flex items-center justify-center h-12 w-12 rounded-md bg-blue-500 text-white">
                        <item.icon className="h-6 w-6" aria-hidden="true" />
                      </div>
                      <h3 className="mt-4 text-lg font-medium text-gray-900">{item.title}</h3>
                      <p className="mt-2 text-base text-gray-500">{item.description}</p>
                    </div>
                    <div className="bg-gray-50 px-6 py-4">
                      <Link className="text-base font-medium text-blue-600 hover:text-blue-500">
                        Saber más <span aria-hidden="true">&rarr;</span>
                      </Link>
                    </div>
                  </motion.div>
                ))}
              </div>
            </div>
          </div>
        </section>

        <section className="bg-blue-600 text-white py-20">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 text-center">
            <motion.h2
              className="text-3xl font-extrabold mb-8"
              initial="hidden"
              animate={isVisible ? "visible" : "hidden"}
              variants={fadeIn}
              transition={{ duration: 0.6 }}
            >
              ¿Por qué elegir PrestEmpresa?
            </motion.h2>
            <div className="grid md:grid-cols-3 gap-8">
              {[
                { title: 'Experiencia', description: 'Más de 10 años optimizando empresas' },
                { title: 'Personalización', description: 'Soluciones adaptadas a tu negocio' },
                { title: 'Soporte 24/7', description: 'Estamos siempre a tu disposición' },
              ].map((item, index) => (
                <motion.div
                  key={item.title}
                  className="bg-white bg-opacity-10 rounded-lg p-6"
                  initial="hidden"
                  animate={isVisible ? "visible" : "hidden"}
                  variants={fadeIn}
                  transition={{ duration: 0.6, delay: 0.1 * index }}
                >
                  <h3 className="text-xl font-semibold mb-4">{item.title}</h3>
                  <p>{item.description}</p>
                </motion.div>
              ))}
            </div>
          </div>
        </section>

        <section className="bg-white py-20">
          <div className="max-w-4xl mx-auto text-center px-4 sm:px-6 lg:px-8">
            <motion.h2
              className="text-3xl font-extrabold text-gray-900 mb-6"
              initial="hidden"
              animate={isVisible ? "visible" : "hidden"}
              variants={fadeIn}
              transition={{ duration: 0.6 }}
            >
              Empieza a transformar tu negocio hoy mismo
            </motion.h2>
            <motion.p
              className="text-xl text-gray-500 mb-10"
              initial="hidden"
              animate={isVisible ? "visible" : "hidden"}
              variants={fadeIn}
              transition={{ duration: 0.6, delay: 0.2 }}
            >
              Descubre cómo nuestras soluciones pueden impulsar el crecimiento y la eficiencia de tu empresa.
            </motion.p>
            <motion.div
              initial="hidden"
              animate={isVisible ? "visible" : "hidden"}
              variants={fadeIn}
              transition={{ duration: 0.6, delay: 0.4 }}
            >
              <Link className="inline-flex items-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 md:py-4 md:text-lg md:px-10">
                Contáctanos
                <ChevronRight className="ml-2 -mr-1 h-5 w-5" aria-hidden="true" />
              </Link>
            </motion.div>
          </div>
        </section>
      </main>

      <footer className="bg-gray-800 text-white py-12">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
            <div>
              <h3 className="text-lg font-semibold mb-4">Empresa</h3>
              <ul className="space-y-2">
                <li><Link className="hover:text-blue-400">Sobre nosotros</Link></li>
                <li><Link className="hover:text-blue-400">Carreras</Link></li>
                <li><Link className="hover:text-blue-400">Socios</Link></li>
              </ul>
            </div>
            <div>
              <h3 className="text-lg font-semibold mb-4">Soluciones</h3>
              <ul className="space-y-2">
                <li><Link className="hover:text-blue-400">Gestión financiera</Link></li>
                <li><Link className="hover:text-blue-400">Recursos humanos</Link></li>
                <li><Link className="hover:text-blue-400">Seguridad y cumplimiento</Link></li>
              </ul>
            </div>
            <div>
              <h3 className="text-lg font-semibold mb-4">Recursos</h3>
              <ul className="space-y-2">
                <li><Link className="hover:text-blue-400">Blog</Link></li>
                <li><Link className="hover:text-blue-400">Webinars</Link></li>
                <li><Link className="hover:text-blue-400">Casos de éxito</Link></li>
              </ul>
            </div>
            <div>
              <h3 className="text-lg font-semibold mb-4">Contacto</h3>
              <ul className="space-y-2">
                <li><a href="mailto:info@prestempresa.com" className="hover:text-blue-400">info@prestempresa.com</a></li>
                <li><a href="tel:+34900123456" className="hover:text-blue-400">+34 900 123 456</a></li>
                <li>Calle Ejemplo, 123, 28001 Madrid</li>
              </ul>
            </div>
          </div>
          <div className="mt-8 pt-8 border-t border-gray-700 text-center">
            <p>&copy; 2024 PrestEmpresa. Todos los derechos reservados.</p>
          </div>
        </div>
      </footer>
    </div>
  );
}