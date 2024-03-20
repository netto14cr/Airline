/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Cliente;
import Modelo.Fecha;
import Modelo.LineaDetalleCliente;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author gabri
 */
public class servicioCliente extends servicio{
    //........... declaraciones de las variables con los nombres de los metodos en la base de datos.
    private static final String INSERTARCLIENTE = 
            "{call insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String MODIFICARCLIENTE = 
            "{call modificarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String LISTARCLIENTES = "{?=call listarClientes()}";
    private static final String CONSULTARCLIENTE = "{?=call consultarCliente(?)}";
    private static final String ELIMINARCLIENTE = "{call eliminarCliente(?)}";
    
    //---------------------- F I N __ D E C L A R A C I Ó N ---------------
    
    public void insertarCliente(Cliente cliente) 
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARCLIENTE);
            pstmt.setString(1, cliente.getFechaNacimiento().getDia());
            pstmt.setString(2, cliente.getFechaNacimiento().getHora());
            pstmt.setString(3, cliente.getFechaNacimiento().getMes());
            pstmt.setString(4, cliente.getFechaNacimiento().getAnio());
            pstmt.setString(5, cliente.getIdentificacion());
            pstmt.setString(6, cliente.getContrasenia());
            pstmt.setString(7, cliente.getNombre());
            pstmt.setString(8, cliente.getApellido1());
            pstmt.setString(9, cliente.getApellido2());
            pstmt.setString(10, cliente.getCorreoElectronico());
            pstmt.setString(11, cliente.getDireccion());
            pstmt.setString(12, cliente.getTipoUsuario());
            pstmt.setString(13, cliente.getTelefonoTrabajo());
            pstmt.setString(14, cliente.getCelular());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminarCliente(String id)
    {
         try {
            conectar();
        } catch (ClassNotFoundException e) {
             try {
                 throw new GlobalException("No se ha localizado el driver");
             } catch (GlobalException ex) {
                 Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (SQLException e) {
             try {
                 throw new NoDataException("La base de datos no se encuentra disponible");
             } catch (NoDataException ex) {
                 Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARCLIENTE);
            pstmt.setString(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
             try {
                 throw new GlobalException("Llave duplicada");
             } catch (GlobalException ex) {
                 Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
             }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void modificarCliente(Cliente cliente)
    {
          try {
            conectar();
        } catch (ClassNotFoundException e) {
              try {
                  throw new GlobalException("No se ha localizado el driver");
              } catch (GlobalException ex) {
                  Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
              }
        } catch (SQLException e) {
              try {
                  throw new NoDataException("La base de datos no se encuentra disponible");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARCLIENTE);
            pstmt.setString(1, cliente.getFechaNacimiento().getDia());
            pstmt.setString(2, cliente.getFechaNacimiento().getHora());
            pstmt.setString(3, cliente.getFechaNacimiento().getMes());
            pstmt.setString(4, cliente.getFechaNacimiento().getAnio());
            pstmt.setString(5, cliente.getIdentificacion());
            pstmt.setString(6, cliente.getContrasenia());
            pstmt.setString(7, cliente.getNombre());
            pstmt.setString(8, cliente.getApellido1());
            pstmt.setString(9, cliente.getApellido2());
            pstmt.setString(10, cliente.getCorreoElectronico());
            pstmt.setString(11, cliente.getDireccion());
            pstmt.setString(12, cliente.getTipoUsuario());
            pstmt.setString(13, cliente.getTelefonoTrabajo());
            pstmt.setString(14, cliente.getCelular());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
              try {
                  throw new GlobalException("Llave duplicada");
              } catch (GlobalException ex) {
                  Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
              }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<LineaDetalleCliente> listarClientes()
    {
          try {
            conectar();
        } catch (ClassNotFoundException ex) {
              try {
                  throw new GlobalException("No se ha localizado el Driver");
              } catch (GlobalException ex1) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex1);
              }
        } catch (SQLException e) {
              try {
                  throw new NoDataException("La base de datos no se encuentra disponible");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        }

        ResultSet rs = null;
        ArrayList<LineaDetalleCliente> coleccion = new ArrayList<>();
        LineaDetalleCliente linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARCLIENTES);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                linea= new LineaDetalleCliente(
                 rs.getString("identificacion")
                ,rs.getString("nombre")
                ,rs.getString("apellido1")
                ,rs.getString("apellido2")
                ,rs.getString("celular")
                ,rs.getString("contrasenia"));
                coleccion.add(linea);
            }
            
        } catch (SQLException e) {
              try {
                  throw new GlobalException("Sentencia no valida");
              } catch (GlobalException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (coleccion == null || coleccion.isEmpty()) {
              try {
                  throw new NoDataException("No hay datos");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        return coleccion;
    }
    
    public Cliente consultarCliente(String id)
    {
             try {
            conectar();
        } catch (ClassNotFoundException ex) {
           System.out.print("No se ha localizado el Driver");
        } catch (SQLException e) {
            System.out.print("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        
        Cliente linea = null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(CONSULTARCLIENTE);
            pstmt.setString(2, id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            Fecha d=new Fecha();
            d.setAnio(rs.getString("anio"));
            d.setDia(rs.getString("dia"));
            d.setHora(rs.getString("hora"));
            d.setMes(rs.getString("mes"));
            linea= new Cliente(
                rs.getString("identificacion")
                ,rs.getString("contrasenia")
                ,rs.getString("nombre")
                ,rs.getString("apellido1")
                ,rs.getString("apellido2")
                ,rs.getString("correoelectronico")
                ,d
                ,rs.getString("direccion")
                ,rs.getString("tipousuario")
                ,rs.getString("telefono")    
                ,rs.getString("celular")
            );

        } catch (SQLException e) {
            e.printStackTrace();            
            System.out.print("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                System.out.print("Estatutos invalidos o nulos");
            }
        }
    
        return linea;
    }
    
 
    
    
    
    
    
    
    
    
    
    
}
